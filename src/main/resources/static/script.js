'use strict';

function updateEndPoint(value) {
	console.log(value)
	const form = document.querySelector('form');
	form.action = '/available_books/' + value;
	console.log(form.action)
}