package com.ig.jan13.linksharing

class LoginController {

    def index() {
    render (view: 'login')
    }

    def logout(){
        session.invalidate()
        redirect(action:'index')

    }
    def user(){
        render (view: "userlogin")

    }
}
