<template>
  <div id="login">
    <div class="login-box">
      <h2>登录系统</h2>
      <form>
        <div class="user-box">
          <input type="text" name="" required="" v-model="loginForm.username" autocomplete = "new-password" @keyup.enter="login">
          <label>用户名</label>
        </div>
        <div class="user-box">
          <input type="password" name="" required="" v-model="loginForm.password" autocomplete = "new-password">
          <label>密码</label>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a @click="login">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          登录
        </a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
        <a @click="signUp_asd">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          注册
        </a>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import request from "../../utils/request";

export default {
  name: "Login",
  data() {
    return {
      loginForm:{
      username: '',
      password: '',
      },
    }
  },
  methods: {
    signUp_asd(){
      this.$router.push('/login/signup');
    },
   
    login() {
      
      axios.post('/login',{
          username:this.loginForm.username,
          password:this.loginForm.password,
         
        })
        .then(res=>{
          if(res.data.code===200)
          { 
           
            this.$router.push('/user');
          }else{
             console.log('400')
            alert('登陆失败');
          }
       })
     }
  },

}

</script>

<style>
#login{
  background: url("https://vkceyugu.cdn.bspapp.com/VKCEYUGU-b96599d7-a53c-4774-935d-82adf58002ac/b818f539-3614-4405-ab02-f16466158a48.jpg");
  position: fixed;
  background-size: cover;
  width:100%;
  height:100%;
  caret-color: transparent;
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0, 0, 0, .5);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

	input:-webkit-autofill,
	input:-webkit-autofill:hover,
	input:-webkit-autofill:focus, 
	input:-webkit-autofill:active {
		transition-delay: 999999999s;
	    transition: color  999999999s ease-out, background-color  999999999s ease-out;
	    -webkit-transition-delay:  999999999s;
	    -webkit-transition: color  999999999s ease-out, background-color  999999999s ease-out;
	    -webkit-text-fill-color: #fff;
	}
.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}
.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #03e9f4;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 40px;
  letter-spacing: 4px
}
.login-box form a:hover{
 cursor:default;
}
.login-box h2:hover{
 cursor:default;

}
.login-box a:hover {
  background: #03e9f4;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #03e9f4,
  0 0 25px #03e9f4,
  0 0 50px #03e9f4,
  0 0 100px #03e9f4;
}

.login-box a span {
  position: absolute;
  display: block;
}

.login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #03e9f4);
  animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%, 100% {
    left: 100%;
  }
}

.login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #03e9f4);
  animation: btn-anim2 1s linear infinite;
  animation-delay: .25s
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%, 100% {
    top: 100%;
  }
}

.login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #03e9f4);
  animation: btn-anim3 1s linear infinite;
  animation-delay: .5s
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%, 100% {
    right: 100%;
  }
}

.login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #03e9f4);
  animation: btn-anim4 1s linear infinite;
  animation-delay: .75s
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%, 100% {
    bottom: 100%;
  }
}


</style>
