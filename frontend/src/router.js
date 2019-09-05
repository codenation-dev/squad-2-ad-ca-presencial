import Vue from "vue";
import Router from "vue-router";

import FormLogin from "@/views/Login/Form";
import FormRegister from "@/views/Register/Form";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/login",
      name: "login",
      component: FormLogin
    },
    {
      path: "/register",
      name: "register",
      component: FormRegister
    }
  ]
});
