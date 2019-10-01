document.addEventListener('DOMContentLoaded', function() {
	const HOME_PAGE = '/home.jsp';
	var path = window.location.pathname;
	var page = path.substr(path.lastIndexOf('/'));
	if (page === HOME_PAGE) {
		addCheckBox();
	}
	
});

function sendData(section) {
	var sect = document.createElement("input");
	sect.name = "section";
	sect.type = "hidden";
	sect.value = section;
	
	var form = document.createElement("form");
	form.method = "post";
	form.action = "/WebProject/conf";
	form.style = "none";
	
	form.appendChild(sect);
	document.body.append(form);
	form.submit();
}

function getConf(id) {
	var input = document.createElement("input");
	input.name = "idConf";
	input.type = "hidden";
	input.value = id;
	
	var form = document.createElement("form");
	form.method = "get";
	form.action = "/WebProject/viewConf";
	form.style = "none";
	
	form.append(input);
	document.body.append(form);
	form.submit();
}

function deleteConf() {
	deleteForm.submit();
}

function addEvent() {
	var event = document.getElementById('event')
	var newEvent = event.cloneNode(true);
	var childs = newEvent.children;
	childs[0].value = "";
	childs[1].value = "";
	var button = createButton();
	newEvent.append(button);
	addConf.append(newEvent);
}

function createButton() {
	var input = document.createElement("input");
	input.type = "button";
	input.value = "Delete";
	input.onclick = deleteEvent; 
	return input;
}

function deleteEvent(event) {
	var item = event.target.parentElement;
	item.remove();
}


function addCheckBox() {
	var rows = document.querySelectorAll("tr");
	
	for (let i = 1; i < rows.length; i++) {
		let idConf = rows[i].firstElementChild.firstChild.nodeValue;
		let td = createCell(idConf);
		rows[i].insertAdjacentElement("beforeend", td);
		
	}
}

function createCell(idConf){
	var td = document.createElement("td");
	var input = document.createElement("input");
	input.name = "idConf";
	input.type = "checkbox";
	input.value = idConf;
	input.style = "form-check-label";
	td.append(input);
	
	return td;
}