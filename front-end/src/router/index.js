import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
//import Students from '@/components/Students'
import Professors from '@/components/Professors'
import Users from '@/components/Users'



Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    //{
      //path: '/students',
      //name: 'Students',
      //component: Students
    //},
    {
      path: '/professors',
      name: 'Professors',
      component: Professors
    },
    {
      path: '/users',
      name: 'Users',
      component: Users
    },
  ]
})
