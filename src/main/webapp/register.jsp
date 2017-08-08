
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Add Users using ajax</title>
       <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2016.3.1028/styles/kendo.common-material.min.css" />
          <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2016.3.1028/styles/kendo.material.min.css" />
          <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

   </head>
    <body>
       <div class="vertical-center-row">
        <h1><center>Add Lead</center</h1>
        <br><br>
        <table>
            <tr><td>Enter your name : </td><td> <input type="text" id="email"><br/></td></tr>
             <tr><td>Enter your Email : </td><td> <input type="text" id="name"><br/></td></tr>
             <tr><td>Enter your Phone : </td><td> <input type="text" id="phone"><br/></td></tr>


            <tr><td colspan="2"><input type="button" value="Add Lead" onclick="doAjaxPost()"><br/></td></tr>
            <tr><td colspan="2"><div id="info" style="color: green;"></div></td></tr>
        </table>
      </div>
      <br><br>
      <div id="userSessionHourlyGrid"></div>
    </body>
</html>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://kendo.cdn.telerik.com/2016.3.1028/js/kendo.all.min.js"></script>
        <script type="text/javascript">


        function doAjaxPost() {

        var name = $('#name').val();
        var email = $('#email').val();
        var phone = $('#phone').val();
        var json = { "email" : email, "name":name,"phone":phone};
        $.ajax({
        url: "/v1/register",
        contentType: "application/json; charset=utf-8",
        type: "POST",
        data : JSON.stringify(json),
        success: function(data){
        // we have the response

        $('#name').val('');
        $('#email').val('');
        $('#phone').val('');
        },
        error: function(e){
        alert('Error: ' + e);
        }
        });
        }




      $("#userSessionHourlyGrid").kendoGrid({
            dataSource: {
                data: [],
                schema: {
                    model: {
                        fields: {
                            name: {
                                type: "string"
                            },
                            email: {
                                type: "string"
                            },
                            phone: {
                                type: "string"
                            },

                  valid:{
                     type:"Boolean"
                  }

                        }
                    }
                },
                pageSize: 200
            },
            scrollable: true,
            sortable: true,
            groupable: true,
            pageable: {
                pageSizes: true,
                buttonCount: 3
            },
            filterable: true,
            resizable: true,
            columns: [{
                field: "name",
                template: "#=decodeURIComponent(name)#",
                title: "Name"
            },
             {
                field: "email",
                template: "#=decodeURIComponent(email)#",
                title: "email"
            },
            {
                field: "phone",
                template: "#=decodeURIComponent(phone)#",
                title: "phone"
            }
            ]
        });
        $(document).ready(function(){

      $.ajax({
         url :"/v1/employees",
         type : 'GET',
         dataType : 'json',
         success : function (result) {
            var sesdata = result;
            buildUserInfoHourlyGrid(result);

         },

         error : function (xhr, status, error) {

         }
      });
      });
      buildUserInfoHourlyGrid = function (result) {
         if(result!=' '){
            if ($("#userSessionHourlyGrid").data("kendoGrid")!=' ') {
               var hourlyData = result;
               $("#userSessionHourlyGrid").data("kendoGrid").dataSource.data(hourlyData);
            }
         }
      };

        </script>
