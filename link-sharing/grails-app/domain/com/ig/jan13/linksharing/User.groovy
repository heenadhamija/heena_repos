package com.ig.jan13.linksharing

class User {
    String firstname
    String lastname
    String email
    String password
    Date dateCreated
    Date lastUpdated

    boolean male
    Date Dateofbirth
    static hasMany = [subscription:Subscription,topics:Topic,reading:ReadingItem]
    static constraints = {
    email(unique:true,email:true,nullable:false,blank:false)
    }


}
