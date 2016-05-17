/**
 * Created by Anvar on 08.05.16.
 */

$('#password_retype_error').hide();

$('#form_sign_up').on('submit', function () {

    if ($('#password').val() != $('#password_retype').val()){
        $('#password_retype_error').show();

        return false;
    } else {
        $('#password_retype_error').hide();
    }

    return true;
});