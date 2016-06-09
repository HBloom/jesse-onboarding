(function() {

    $("#submit-button").click(function() {

        var coinNames = $('input[name="coinNames"]').map(function() {
            return $(this).val();
        }).get().join();

        var coinValues = $('input[name="coinValues"]').map(function() {
            return $(this).val();
        }).get().join();

        var amount = $('input[name="coinAmount"]').val();

        $.ajax({
            url: "/change",
            method: "POST",
            data: {
                "coinNames": coinNames,
                "coinValues": coinValues,
                "totalAmount": amount
            }

        }).then(
            function(response) {
                console.log(response);
            },
            function(error) {
                console.log(error);
            }
        );


    });


})();
