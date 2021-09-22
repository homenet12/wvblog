/**
 * 
 */

function imageUpload(image, callback) {
	var httpRequest = new XMLHttpRequest();
	var imageUrl = "";

	if (!httpRequest) {//실패
		return false;
	}
	var data = new FormData();
	data.append('multipartFile', image);
	//onreadystatechange
	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				imageUrl = httpRequest.responseText;
				setTimeout(() => callback(imageUrl, 'alt text'), 1000);	//파일 인식이 바로 되지않음.
			} else {
				alert('request에 뭔가 문제가 있어요.');
			}
		}
	};
	httpRequest.open('POST', '/board/imageUpload');
	//httpRequest.setRequestHeader('Content-Type', 'application/json');
	httpRequest.send(data);
}