/**
 * Created by Anvar on 08.05.16.
 */

$('.menu .item').tab();

$('.ui.rating').rating();

$('#review-add-form').on('submit', function(){
    var rating = $('#form-rating').rating('get rating');
    $('#rating').val(rating);
    //$.ajax({
    //    type: "POST",
    //    url: "/api/review/send",
    //    success: function(response) {
    //        console.log( response );
    //    }
    //});
});

function getReview() {
    $.ajax({
        type: "GET",
        url: "/api/review/get/1",
        success: function(response) {
            console.log( response );
        }
    });
}