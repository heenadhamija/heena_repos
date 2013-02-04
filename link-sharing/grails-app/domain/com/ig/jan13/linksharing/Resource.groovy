package com.ig.jan13.linksharing

 class Resource {


    String title
    String summary
    Date dateCreated
    Date lastUpdated
    User user

    static belongsTo = [topics:Topic]

    static constraints = {
        title(unique:'topics')
        summary(maxSize:1024,blank: false)
            }


}
