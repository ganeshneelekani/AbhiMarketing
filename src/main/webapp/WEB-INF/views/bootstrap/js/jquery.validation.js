$(document).ready(function() {
    // validate the comment form when it is submitted

    $.validator.addMethod(
        "regex",
        function(value, element, regexp) {
            if (regexp.constructor != RegExp)
                regexp = new RegExp(regexp);
            else if (regexp.global)
                regexp.lastIndex = 0;
            return this.optional(element) || regexp.test(value);
        },
        "Please check your input."
    );


    // validate signup form on keyup and submit
    $("#loginForm").validate({

        //        onkeyup: false,
        //        errorClass: "req_mess",
        //        ignore: ":hidden",
        //        validClass: "signup_valid_class",
        //        errorClass: "signup_error_class",

        rules: {
            mobileNumber: {
                required: true,
                regex: /^[0-9]{10,10}$/,
                minlength: 10,
                maxlength: 10

            },
            password: {
                required: true,
                minlength: 5
            }
        },
        messages: {
            mobileNumber: {
                regex: "Mobile Number must be at 10 digit Number",
                required: "Please provide Contact Number",
                minlength: "Your Contact Number must be at 10 digit Number"
            },
            password: {
                required: "Please provide a Password",
                minlength: "Your password must be at least 5 characters long"
            }
        },
        submitHandler: function(form) {
            return true;
        }
    })
});