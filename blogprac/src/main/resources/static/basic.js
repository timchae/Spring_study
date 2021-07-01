let temp_id;
$(document).ready(function () {
    // HTML 문서를 로드할 때마다 실행합니다.
    getPost();
    $('#one_post').hide();
})


function deletePost(id){
    $.ajax({
        type: "DELETE",
        url: `/api/post/${id}`,
        success: function (response) {
            alert('포스트 삭제에 성공하였습니다.');
            window.location.reload();
        }
    })
}
function editsave(){

    let title = $('#titlee').val();
    let content = $('#contentse').val();
    let name = $('#namee').val();
    let url = $('#img_urle').val();

    if(url == ""){
        url = "images/tim.jpeg"
    }

    if(isValidContents(title) == false){
        alert('제목을 입력해주세요');
        return;
    }
    if(isValidContents(content) == false){
        alert('내용을 입력해주세요');
        return;
    }
    if(isValidContents(name) == false){
        alert('이름을 입력해주세요');
        return;
    }
    let data = {'name': name,'title':title, 'contents': content, 'url': url}
    $.ajax({
        type: "PUT",
        url: `/api/post/${temp_id}`,
        contentType: "application/json", // JSON 형식으로 전달함을 알리기
        data: JSON.stringify(data),
        success: function (response) {
            alert('메시지가 성공적으로 수정되었습니다.');
            window.location.reload();
        }
    });
}
function editPost(id){
    temp_id = id;
    console.log(id);
    $('#postingedit').addClass('is-active');
}

function addOnePost(id, name, title, contents, modifiedAt, url){
    $('#one_post').empty();
    let temphtml =`<div>
                        <div class="card" style="width: 70%; margin: auto">
                            <div class="card-image">
                                <figure class="image is-4by3">
                                    <img src="${url}" alt="Placeholder image">
                                </figure>
                            </div>
                        </div>
                        <section class="section" style="width: 80%; margin: auto">
                            <div class="tile is-ancestor">
                                <div class="tile is-parent">
                                    <div class="tile is-child box">
                                        <p id="${id}-title" class="title">${title}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="tile is-ancestor">
                                <div class="tile is-parent">
                                    <div class="tile is-child box">
                                        <p id="${id}-contents">${contents}</p>
                                        <p class="card-text">
                                            <small id="${id}-name" class="text-muted">${name}</small>
                                            <small class="text-muted"> ${modifiedAt}</small>
                                        </p>
                                        <div class="buttons">
                                            <button class="button is-link is-light" onclick="editPost('${id}')">수정하기</button>
                                            <button class="button is-link is-light" onclick="deletePost('${id}')">삭제하기</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>`
    $('#one_post').append(temphtml);
}

function posth(id){
    $.ajax({
        type: 'GET',
        url: `/api/post/${id}`,
        success: function (response) {

            let id = response.id;
            let name = response.name;
            let title = response.title;
            let contents = response.contents;
            let modifiedAt = response.modifiedAt;
            let url = response.url;
            addOnePost(id, name, title, contents, modifiedAt, url)

            console.log(response)
        }
    })
    $('#post-cards').hide();
    $('#one_post').show();
}

function addHTML(id, name, title, contents, modifiedAt, url) {
    console.log(url)
    let temphtml = `<div class="card mb-3" onclick="posth('${id}')">
                                <img src="${url}" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">${title}</h5>
                                    <p class="card-text">${contents}</p>
                                    <p  class="card-text">
                                        <small class="text-muted">${name}</small>
                                        <small class="text-muted">${modifiedAt}</small>
                                    </p>
                                </div>
                            </div>`
    $('#post-cards').append(temphtml);
}

function getPost() {
    $("#post-cards").empty();

    $.ajax({
        type: 'GET',
        url: '/api/post',
        success: function (response) {

            for(let i = 0 ;i < response.length; i++){
                let id = response[i].id;
                let name = response[i].name;
                let title = response[i].title;
                let contents = response[i].contents;
                let modifiedAt = response[i].modifiedAt;
                let url = response[i].url;
                if(contents.length > 100){
                    contents = contents.substring(0,100);
                    contents = contents + '  . . .';
                }
                addHTML(id, name,title, contents, modifiedAt, url)
            }
        }
    })
}

function isValidContents(contents) {
    if (contents == '') {
        return false;
    }
    if (contents.trim().length > 1000) {
        alert('공백 포함 140자 이하로 입력해주세요');
        return false;
    }
    return true;
}

function addPost() {
    let title = $('#title').val();
    let content = $('#contents').val();
    let name = $('#name').val();
    let url = $('#img_url').val();
    // content= content.replace("\n","<br/>")
    if(isValidContents(title) == false){
        alert('제목을 입력해주세요');
        return;
    }
    if(isValidContents(content) == false){
        alert('내용을 입력해주세요');
        return;
    }
    if(isValidContents(name) == false){
        alert('이름을 입력해주세요');
        return;
    }
    if(url == ""){
        url = "images/tim.jpeg"
    }
    let data = {'name': name,'title':title, 'contents': content,'url': url}

    console.log(data);

    $.ajax({
        type: "POST",
        url: "/api/post",
        contentType: "application/json", // JSON 형식으로 전달함을 알리기
        data: JSON.stringify(data),
        success: function (response) {
            alert('메시지가 성공적으로 작성되었습니다.');
            window.location.reload();
        }
    });
}

function post() {
    $('#posting').addClass('is-active');
}

function post_close() {
    $('#posting').removeClass('is-active');
    $('#title').val("");
    $('#contents').val("");
    $('#name').val("");

    $('#postingedit').removeClass('is-active');
    $('#titlee').val("");
    $('#contentse').val("");
    $('#namee').val("");

}

function reload(){
    window.location.reload();
}