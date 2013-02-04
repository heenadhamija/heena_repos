package com.ig.jan13.linksharing

class Topic {

               String name
                Visibility visibility
    static constraints = {
      name(unique: true,blank: false)
    }
    static belongsTo = [owner:User]
    static hasMany = [subscriptions:Subscription,resources:Resource]
}
