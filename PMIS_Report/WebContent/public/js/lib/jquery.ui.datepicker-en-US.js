/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
jQuery(function($){
	$.datepicker.regional['en_US'] = {
		closeText: 'Close',
		prevText: '&#x3c;Last Month',
		nextText: 'Next Month&#x3e;',
		currentText: 'Today',
		monthNames: ['January','Feberary','March','April','May','June',
		'July','August','September','October','November','December'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','May','Jun',
		'Jul','Aug','Sep','Oct','Nov','Dec'],
		dayNames: ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'],
		dayNamesShort: ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'],
		dayNamesMin: ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'],
		weekHeader: 'Week',
		dateFormat: 'yy-mm-dd',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: 'Year'};
	
	$.timepicker.regional['en_US'] = {
			timeOnlyTitle: 'Choose Time',
			timeText: 'Time',
			hourText: 'Hour',
			minuteText: 'Minute',
			secondText: 'Second',
			millisecText: 'Millisecond',
			currentText: 'Now',
			closeText: 'Close',
			ampm: false
		};
});
