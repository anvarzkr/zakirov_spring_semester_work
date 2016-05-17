/**
 * Created by Anvar on 09.05.16.
 */

$('#password_retype_error').hide();

$('#form_sign_up').on('submit', function () {

    var password = $('#password').val();

    if ( password != '') {

        if (password != $('#password_retype').val()) {
            $('#password_retype_error').show();

            return false;
        } else {
            $('#password_retype_error').hide();
        }
    }

    return true;
});