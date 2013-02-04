import com.ig.jan13.linksharing.LinkResource
import com.ig.jan13.linksharing.ReadingItem
import com.ig.jan13.linksharing.Resource
import com.ig.jan13.linksharing.Seriousness
import com.ig.jan13.linksharing.Subscription
import com.ig.jan13.linksharing.Topic
import com.ig.jan13.linksharing.User
import com.ig.jan13.linksharing.Visibility

class BootStrap {

    def init = { servletContext ->

        User user1=new User(firstname: "Mahak",lastname: "Chilana",email: "mahakchilana@gmail.com", password: "mahak",male: false,Dateofbirth: new Date("06/08/1988"))
        User user2=new User(firstname: "Heena",lastname: "Dhamija",email: "heena.dha@gmail.com", password: "heena",male: false,Dateofbirth: new Date("17/11/1989"))

        Topic topic1=new Topic( name: "Groovy",visibility: Visibility.PRIVATE)
        Topic topic2=new Topic( name: "Grails",visibility: Visibility.PUBLIC)
        user1.addToTopics(topic1)
        user2.addToTopics(topic2)
        //println topic.validate()
        user1.save()
        user2.save()
        Subscription subscribe1=new Subscription(serious: Seriousness.SERIOUS)
        Subscription subscribe2=new Subscription(serious: Seriousness.CASUAL)
        topic1.addToSubscriptions(subscribe1)
        topic2.addToSubscriptions(subscribe2)
        user1.addToSubscription(subscribe1)
        user2.addToSubscription(subscribe2)

        println(user1.validate())
        println(user2.validate())
        println(topic1.validate())
        println(topic2.validate())
        println(subscribe1.validate())
        println(subscribe2.validate())
        if (!user1.validate()){
            user1.errors.allErrors.each {println it}

        }

        if (!topic1.validate()){
            topic1.errors.allErrors.each {println it}

        }
        if (!subscribe1.validate()){
            subscribe1.errors.allErrors.each {println it}

        }
        if (!topic2.validate()){
            topic2.errors.allErrors.each {println it}

        }
        if (!subscribe2.validate()){
            subscribe2.errors.allErrors.each {println it}

        }
        user1.save()
        user2.save()
        User u1=User.get(1)
        User u2=User.get(2)
        topic1.save()
        topic2.save()

        LinkResource link1=new LinkResource(url: "http://www.google.com",title: "GOOGLE",summary: "GOOGLE PAGE",user: u1)
        LinkResource link2=new LinkResource(url: "http://www.gmail.com",title: "GMAIL",summary: "GMAIL PAGE",user: u1)
        LinkResource link3=new LinkResource(url: "http://www.facebook.com",title: "FACEBOOK",summary: "FACEBOOK PAGE",user: u1)
        LinkResource link4=new LinkResource(url: "http://www.hotmail.com",title: "HOT MAIL",summary: "HOTMAIL PAGE",user: u1)
        LinkResource link5=new LinkResource(url: "http://www.rediffmail.com",title: "REDIFFMAIL",summary: "REDIFFMAIL PAGE",user: u1)

        LinkResource link6=new LinkResource(url: "http://www.google.com",title: "GOOGLE",summary: "GOOGLE PAGE",user: u2)
        LinkResource link7=new LinkResource(url: "http://www.gmail.com",title: "GMAIL",summary: "GMAIL PAGE",user: u2)
        LinkResource link8=new LinkResource(url: "http://www.facebook.com",title: "FACEBOOK",summary: "FACEBOOK PAGE",user: u2)
        LinkResource link9=new LinkResource(url: "http://www.hotmail.com",title: "HOT MAIL",summary: "HOTMAIL PAGE",user: u2)
        LinkResource link10=new LinkResource(url: "http://www.rediffmail.com",title: "REDIFFMAIL",summary: "REDIFFMAIL PAGE",user: u2)
        topic1.addToResources(link1)
        topic1.addToResources(link2)
        topic1.addToResources(link3)
        topic1.addToResources(link4)
        topic1.addToResources(link5)
        topic2.addToResources(link6)
        topic2.addToResources(link7)
        topic2.addToResources(link8)
        topic2.addToResources(link9)
        topic2.addToResources(link10)

        println(link1.validate())
        println(link2.validate())
        println(link3.validate())
        println(link4.validate())
        println(link5.validate())
        println(link6.validate())
        println(link7.validate())
        println(link8.validate())
        println(link9.validate())
        println(link10.validate())
        if (!link1.validate()){
            link1.errors.allErrors.each {println it}

        }

        if (!link2.validate()){
            link2.errors.allErrors.each {println it}

        }
        if (!link3.validate()){
            link3.errors.allErrors.each {println it}

        }

        if (!link4.validate()){
            link4.errors.allErrors.each {println it}

        }
        if (!link5.validate()){
            link5.errors.allErrors.each {println it}

        }

        topic1.save()
        topic2.save()
        link1.save()
        link2.save()
        link3.save()
        link4.save()
        link5.save()
        link6.save()
        link7.save()
        link8.save()
        link9.save()
        link10.save()



        ReadingItem read1=new ReadingItem(isRead: true,isFavourite: true,resource: link1)
        ReadingItem read2=new ReadingItem(isRead: false,isFavourite: false,resource: link2)
        ReadingItem read3=new ReadingItem(isRead: false,isFavourite: false,resource: link3)
        ReadingItem read4=new ReadingItem(isRead: true,isFavourite: true,resource: link4)
        ReadingItem read5=new ReadingItem(isRead: false,isFavourite: false,resource: link5)
        ReadingItem read6=new ReadingItem(isRead: true,isFavourite: false,resource: link6)
        ReadingItem read7=new ReadingItem(isRead: false,isFavourite: false,resource: link7)
        ReadingItem read8=new ReadingItem(isRead: false,isFavourite: false,resource: link8)
        ReadingItem read9=new ReadingItem(isRead: false,isFavourite: false,resource: link9)
        ReadingItem read10=new ReadingItem(isRead: false,isFavourite: false,resource: link10)
        user1.addToReading(read1)
        user2.addToReading(read2)
        user1.addToReading(read3)
        user2.addToReading(read4)
        user1.addToReading(read5)
        user2.addToReading(read6)
        user2.addToReading(read7)
        user1.addToReading(read8)
        user1.addToReading(read9)
        user2.addToReading(read10)

        println(read1.validate())
        println(read2.validate())
        println(read3.validate())
        println(read4.validate())
        println(read5.validate())
        println(read6.validate())
        println(read7.validate())
        println(read8.validate())
        println(read9.validate())
        println(read10.validate())
        if (!read1.validate()){
            read1.errors.allErrors.each {println it}

        }

        if (!read2.validate()){
            read2.errors.allErrors.each {println it}

        }
        if (!read3.validate()){
            read3.errors.allErrors.each {println it}

        }

        if (!read4.validate()){
            read4.errors.allErrors.each {println it}

        }
        if (!read5.validate()){
            read5.errors.allErrors.each {println it}

        }


        read1.save()
        read2.save()
        read3.save()
        read4.save()
        read5.save()
        read6.save()
        read7.save()
        read8.save()
        read9.save()
        read10.save()


        List <ReadingItem> readingItemList=ReadingItem.findAllWhere(isRead: false,user: u1)
        readingItemList.each {
                    println it.resource.title

        }












    }
    def destroy = {
    }
}
