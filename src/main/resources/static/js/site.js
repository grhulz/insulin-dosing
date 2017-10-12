function setPicker(){
    $('input[name="daterange"]').daterangepicker({
        timePicker: true,
        locale: {
            format: 'MM/DD/YYYY h:mm A'
        }
    },
    function(start, end, label) {
        //alert("A new date range was chosen: " + moment.utc(start).format("YYYY-MM-DD HH:mm:ss[Z]") + ' to ' + moment.utc(end).format("YYYY-MM-DD HH:mm:ss[Z]"));
        document.ui.startDate.value = moment.utc(start).format("YYYY-MM-DD[T]HH:mm:ss[Z]");
        document.ui.endDate.value = moment.utc(end).format("YYYY-MM-DD[T]HH:mm:ss[Z]");
        alert('The start date is ' + document.ui.startDate.value);
        //var redirectLink = window.location.protocol + "//" + window.location.host + window.location.pathname;
        //console.log('Redirecting to: ' + redirectLink);
        //window.location.href = redirectLink;
    });
};

function getRequestParam(p){
    return (window.location.search.match(new RegExp('[?&]' + p + '=([^&]+)')) || [, null])[1];
};

function setInitialDate(){
    var requestDate = getRequestParam('date');
    if(requestDate == null){
        requestDate = new Date();
    }else{
        requestDate = formatDate(requestDate);
    }
    $('#datepicker').datepicker('setDate', requestDate);

};

function reloadPageForDateSelection(){
    var dateRange = document.getElementById('daterange').value;
    var redirectLink = window.location.protocol + "//" + window.location.host + window.location.pathname + '?dateRange=' + dateRange;
    console.log('Redirecting to: ' + redirectLink);
    window.location.href = redirectLink;
};

function formatDate(input) {
    var dateFormat = 'yyyy-mm-dd';
    var parts = input.match(/(\d+)/g),
        i = 0, fmt = {};
    dateFormat.replace(/(yyyy|dd|mm)/g, function(part) { fmt[part] = i++; });

    return new Date(parts[fmt['yyyy']], parts[fmt['mm']]-1, parts[fmt['dd']]);
};

$(document).ready(function(){
    setPicker();
});
