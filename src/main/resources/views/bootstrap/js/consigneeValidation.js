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
    $.validator.addMethod(
        "emailregex",
        function(value, element, emailregex) {
            if (emailregex.constructor != RegExp) emailregex = new RegExp(emailregex);
            else if (emailregex.global) emailregex.lastIndex = 0;
            return this.optional(element) || emailregex.test(value);
        }
    );
    $.validator.addMethod("notEqual", function(value, element, param) {
        return this.optional(element) || value != param;
    }, "Please specify a different value");

    // validate signup form on keyup and submit
    $("#saveConsignee").validate({
        //                onkeyup: false,
        //                errorClass: "req_mess",
        //                ignore: ":hidden",
        //                validClass: "signup_valid_class",
        //                errorClass: "signup_error_class",
        rules: {
            consigneeName: {
                minlength: 1,
                maxlength: 500,
                required: true,
                regex: /^[A-Za-z0-9- ]{1,500}$/
            },
            gstin: {
                minlength: 1,
                maxlength: 45,
                required: true,
                regex: /^[A-Za-z0-9 ]{1,45}$/
            },
            stateCode: {
                required: true,
                regex: /^[A-Za-z0-9 ]{2,45}$/,
                minlength: 2,
                maxlength: 45
            },
            state: {
                required: true,
                regex: /^[A-Za-z0-9 ]{2,45}$/,
                minlength: 2,
                maxlength: 45
            },
            address: {
                required: true,
                regex: /^[A-Za-z0-9 ]{2,500}$/,
                minlength: 2,
                maxlength: 500
            },
            pincode: {

                required: true,
                minlength: 6,
                maxlength: 6,
                regex: /^[0-9]{6,6}$/

            },
            mobileNo: {
                required: true,
                minlength: 10,
                maxlength: 10,
                regex: /^[A-Za-z0-9]{10,10}$/

            },
        },
        messages: {
            consigneeName: {
                required: "Please provide the Name",
                regex: "Only Characters and Number re allowed",
                minlength: "Name should be atlease 2 character",
                maxlength: "Name should be less than 500 character"
            },
            gstin: {
                required: "Please provide the GSTIN",
                regex: "Only Characters and Number re allowed",
                minlength: "Name should be atlease 2 character",
                maxlength: "Name should be less than 45 character"
            },
            state: {
                required: "Please provide a State Name",
                regex: "Only Characters and Number re allowed",
                minlength: "Name should be atlease 2 character",
                maxlength: "Name should be less than 500 character"
            },
            stateCode: {
                required: "Please provide a State Name",
                regex: "Only Characters and Number re allowed",
                minlength: "Name should be atlease 2 character",
                maxlength: "Name should be less than 45 character"
            },
            pincode: {
                required: "Please provide valid Pincode",
                 minlength: "Should be 6 digit",
                 maxlength: "Should be 6 digit",
                regex: "Only Numbers are allowed EX : 560100"
            },
            address: {
                required: "Please provide a Student Address",
                regex: "Please add valid details",
                minlength: "Address should be atlease 2 character",
                maxlength: "Address should be less than 1000 character"
            },
            mobileNo: {
                regex: "Only Numbers are allowed EX : 9999999999",
                required: "Please provide Contact Number",
                minlength: "Your Contact Number must be at 10 digit Number",
                maxlength: "Your Contact Number must be at 10 digit Number"
            }
        },
        submitHandler: function(form) {
            return true;
        }
    })
});