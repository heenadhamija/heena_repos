package com.ig.jan13.linksharing

class AdminController {

    static defaultAction = "stats"
    def beforeInterceptor={
        if(session.name!="admin@intelligrape.com"){

            render "ACCESS DENIED"
            return false

        }

    }
    def stats(){

        int user=User.count()
        println user
        render (view: "usercount",model: [users:user])

    }



}
