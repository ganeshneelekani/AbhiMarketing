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
    $("#addProduct").validate({
        //                onkeyup: false,
        //                errorClass: "req_mess",
        //                ignore: ":hidden",
        //                validClass: "signup_valid_class",
        //                errorClass: "signup_error_class",
        rules: {
            productName: {
                required: true,
                minlength: 2,
                maxlength: 500,
                regex: /^[A-Za-z0-9.\-\[\] ]{2,500}$/
            },
            productId: {
                required: true,
                minlength: 2,
                maxlength: 300,
                required: true,
                regex: /^[A-Za-z0-9]{2,300}$/
            },
            hsnCode: {
                required: true,
                minlength: 2,
                maxlength: 300,
                regex: /^[A-Za-z0-9]{2,300}$/
            },
            gstPercentage: {
                required: true,
                regex: /^[0-9.]+$/

            },
            noOfPiecesPerJar: {
                required: true,
                regex: /^[0-9]+$/

            },
            weightPerJar: {
                required: true,
                regex: /^[0-9.]+$/
            },
            noOfJarsPerCartoon: {
                required: true,
                regex: /^[0-9]+$/
            },
            basicPrice: {
                required: true,
                regex: /^[0-9.]+$/
            }

        },
        messages: {
            productName: {
                required: "Please provide Product Name",
                minlength: "Product Name should be atlease 2 character",
                maxlength: "Product Name should not more than 500 character",
                regex: "Avoid Special characters"

            },
            productId: {
                required: "Please provide a Product Id",
                minlength: "Product Name should be atlease 2 character",
                maxlength: "Product Name should not more than 300 character",
                regex: "Only Characters and Number are allowed "

            },
            hsnCode: {
                required: "Please provide a HSN code",
                minlength: "Product Name should be atlease 2 character",
                maxlength: "Product Name should not more than 300 character",
                regex: "Only Characters and Number are allowed "

            },
            gstPercentage: {
                required: "Please provide GST Percentage",
                regex: "Only  Numbers are allowed "
            },
            noOfPiecesPerJar: {
                required: "Please provide The Number Of Piece/Jar",
                regex: "Only Numbers are allowed "

            },
            weightPerJar: {
                required: "Please provide weight/Jar in Gms",
                regex: "Only Numbers are allowed "

            },
            noOfJarsPerCartoon: {
                required: "Please provide The Number of Jars/Cartoon",
                regex: "Only Numbers are allowed "
            },
            basicPrice: {
                required: "Please Provide The Basic Price",
                regex: "Only Numbers are allowed "
            }

        },
        submitHandler: function(form) {
            return true;
        }
    })
});