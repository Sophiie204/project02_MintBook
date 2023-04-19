import { createRouter, createWebHistory } from 'vue-router'

import MainPage from '../views/MainPage'
import SearchPage from '../views/SearchPage'
import BookDetailPage from '../views/BookDetailPage'
import CartPage from '../views/CartPage'
import OrderPage from '../views/OrderPage'
import OrderResultPage from '../views/OrderResultPage'
import BestsellerPage from '../views/BestsellerPage'
import NewBookPage from '../views/NewBookPage'
import CategoryPage from '../views/CategoryPage'
import EditorPickPage from '../views/EditorPickPage'
import EventPage from '../views/EventPage'
import EventDetailPage from '../views/EventDetailPage'
import CSPage from '../views/CSPage'
import CSRegisterPage from '../views/CSRegisterPage'
import FAQPage from '../views/FAQPage'

const routes = [
  {
    path: '/',
    name: 'mainpage',
    component: MainPage
  },
  {
    path: '/search',
    name: 'searchpage',
    component: SearchPage
  },
  {
    path: '/book',
    name: 'book',
    component: BookDetailPage
  },
  {
    path: '/cart',
    name: 'cart',
    component: CartPage
  },
  {
    path: '/order',
    name: 'order',
    component: OrderPage
  },
  {
    path: '/order-result',
    name: 'orderresult',
    component: OrderResultPage
  },
  {
    path: '/bestseller',
    name: 'bestseller',
    component: BestsellerPage
  },
  {
    path: '/new',
    name: 'new',
    component: NewBookPage
  },
  {
    path: '/category',
    name: 'category',
    component: CategoryPage
  },
  {
    path: '/editorpick',
    name: 'editorpick',
    component: EditorPickPage
  },
  {
    path: '/event',
    name: 'event',
    component: EventPage
  },
  {
    path: '/event/detail',
    name: 'event/detail',
    component: EventDetailPage
  },
  {
    path: '/cs',
    name: 'cs',
    component: CSPage
  },
  {
    path: '/cs/register',
    name: 'csregister',
    component: CSRegisterPage
  },
  {
    path: '/faq',
    name: 'faq',
    component: FAQPage
  },


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
