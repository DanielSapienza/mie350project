import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Users from '@/components/Users'
import Exercises from '@/components/Exercises'
import Diets from '@/components/Diets'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/users',
      name: 'Users',
      component: Users
    },
    {
      path: '/exercises',
      name: 'Exercises',
      component: Exercises
    },    
    {
      path: '/diets',
      name: 'Diets',
      component: Diets
    },
  ]
})
