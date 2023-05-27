<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
      
      <link rel="stylesheet" href="style.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
 <style>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
*{
  margin: 0;
  padding: 0;
  outline: none;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}
body{
  height: 100vh;
  width: 100%;
  background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
}
.error{
	color:red
}
.show-btn{
    background: #fff;
    padding: 10px 20px;
    font-size: 20px;
    border-radius: 90px;
    font-weight: 500;
    color: #216694;
    cursor: pointer;
    box-shadow: 0px -1px 8px 20px rgb(0 0 0 / 10%);
}
.show-btn, .container{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
input[type="checkbox"]{
  display: none;
}
.container{
  display: none;
  background: #fff;
  border-radius: 40px;
  width: 619px;
  padding: 40px;
  box-shadow: 0px -1px 8px 20px rgb(0 0 0 / 10%);
}
#show:checked ~ .container{
  display: block;
}
.container .close-btn{
  position: absolute;
  right: 20px;
  top: 15px;
  font-size: 18px;
  cursor: pointer;
}
.container .close-btn:hover{
  color: #3498db;
}
.container .text{
  font-size: 35px;
  font-weight: 600;
  text-align: center;
}
.container form{
  margin-top: -20px;
}
.container form .data{
  height: 60px;
  width: 100%;
  margin: 50px 0;
}
form .data label{
  font-size: 18px;
}
form .data input{
  height: 100%;
  width: 100%;
  border-radius: 40px;
  padding-left: 10px;
  font-size: 17px;
  border: 1px solid silver;
}
form .data input:focus{
  border-color: #3498db;
  border-bottom-width: 2px;
}


.container form .data1{
  height: 18px;
  width: 100%;
  margin: 40px 0;
}
form .data1 label{
  font-size: 18px;
}
form .data1 input{
  height: 90%;
  width: 9%;
  padding-left: 10px;
  font-size: 17px;
  border: 10px solid silver;
}
form .data1 input:focus{
  border-color: #3498db;
  border-bottom-width: 2px;
}


form .forgot-pass{
  margin-top: -8px;
}
form .forgot-pass a{
  color: #3498db;
  text-decoration: none;
}
form .forgot-pass a:hover{
  text-decoration: underline;
}
form .btn{
  margin: 30px 0;
  height: 45px;
  width: 100%;
  position: relative;
  overflow: hidden;
}
form .btn .inner{
  height: 100%;
  width: 300%;
  position: absolute;
  left: -100%;
  z-index: -1;
  background: -webkit-linear-gradient(right, #56d8e4, #9f01ea, #56d8e4, #9f01ea);
  transition: all 0.4s;
}
form .btn:hover .inner{
  left: 0;
}
form .btn button{
  height: 100%;
  width: 100%;
  background: none;
  border: none;
  color: #fff;
  font-size: 18px;
  font-weight: 500;
  text-transform: uppercase;
  letter-spacing: 1px;
  cursor: pointer;
}
form .signup-link{
  text-align: center;
}
form .signup-link a{
  color: #3498db;
  text-decoration: none;
}
form .signup-link a:hover{
  text-decoration: underline;
}
</style>
      
   </head>
   <body>
       
    <form:form action="AfterRegister" method="post" modelAttribute="User">


      <div class="center">
         <input type="checkbox" id="show">
         <label for="show" class="show-btn">Welcome To Register Page !</label>
         <div class="container">
            <label for="show" class="close-btn fas fa-times" title="close"></label>
            <div class="text">
               Register Form
            </div>
            <form action="#">

                <div class="data">
                
                    <div class="data">
                
                       <label for="Name">Username</label>
                        <form:input type="text" path="Name"/>
                        <form:errors path="Name" cssClass="error"/><br><br>
                    
                

                 </label>
                 
               </div>
               <div class="data">
                <label for="Password">Password</label>
                <form:input type="text" path="Password" />
                <form:errors path="Password" cssClass="error"/><br><br>
              </div>

    
                     </label>
                     
                   </div>

               <div class="data">
          
                <label for="Email">Email</label>
                <form:input type="text" path="Email" /> 
                <form:errors path="Email" cssClass="error"/><br><br>

                 </label>
                 
               </div>

              <br>
               <div class="data1">
                <label>User Type</label>
               
                <br>
                <form:select path="type">
                    <form:options items="${User.userOption}"/>
                </form:select> <br><br><br>
                 <br>

             </div>
             <br>

              
               <div class="btn">
                  <div class="inner"></div>
                  <button type="submit">Register</button>
               </div>
               <div class="signup-link">
                  Already a member? <a href="LoginForm">login now</a>
               </div>
            </form:form> 
         </div>
      </div>
   </body>
</html>