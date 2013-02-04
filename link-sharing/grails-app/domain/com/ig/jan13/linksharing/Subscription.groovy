package com.ig.jan13.linksharing

class Subscription {
                        Date dateCreated
                        Date lastUpdated
        Seriousness serious
    static belongsTo = [user:User,topics:Topic]
    static constraints = {
        topics(unique: "user")
    }

}
