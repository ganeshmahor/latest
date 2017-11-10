var $trigger = $('.modal-open');
var $close = $('.modal-close');
var $modal = $('.modal-box');

/*
$(window).on('resize', function() {
    var top = $trigger.offset().top + $trigger.outerHeight();
    var left = $trigger.offset().left;
    var width = $trigger.outerWidth();
    $trigger.attr({
        'data-top': top,
        'data-left': left,
        'data-width': width
    });
    $modal.css({
        top: top,
        left: left
    });
}).trigger('resize');
*/

$trigger.on('click', function() {
    $modal.css({
        top: 0,
        left: 0,
        width: '100%',
        height: '100%'
    }).addClass('is-open');
	$('#sidebar_secondary').addClass('popup-box-on');
});

$close.on('click', function() {
    var top = $trigger.offset().top + $trigger.outerHeight();
    var left = $trigger.offset().left;
    $modal.css({
        top: top,
        left: left,
        width: 0,
        height: '2px'
    }).removeClass('is-open');
	 $('#sidebar_secondary').removeClass('popup-box-on');
});

$('#modal-trigger').click(function(){
  $(this).addClass('hide');
  $('#modal').addClass('show');
  
});
/*
$(function(){
$("#addClass").click(function () {
  $('#sidebar_secondary').addClass('popup-box-on');
    });
  
    $("#removeClass").click(function () {
  $('#sidebar_secondary').removeClass('popup-box-on');
    });
})
*/