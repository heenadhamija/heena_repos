package com.ig.jan13.linksharing



import org.junit.*
import grails.test.mixin.*

@TestFor(LinkResourceController)
@Mock(LinkResource)
class LinkResourceControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/linkResource/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.linkResourceInstanceList.size() == 0
        assert model.linkResourceInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.linkResourceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.linkResourceInstance != null
        assert view == '/linkResource/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/linkResource/show/1'
        assert controller.flash.message != null
        assert LinkResource.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/linkResource/list'

        populateValidParams(params)
        def linkResource = new LinkResource(params)

        assert linkResource.save() != null

        params.id = linkResource.id

        def model = controller.show()

        assert model.linkResourceInstance == linkResource
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/linkResource/list'

        populateValidParams(params)
        def linkResource = new LinkResource(params)

        assert linkResource.save() != null

        params.id = linkResource.id

        def model = controller.edit()

        assert model.linkResourceInstance == linkResource
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/linkResource/list'

        response.reset()

        populateValidParams(params)
        def linkResource = new LinkResource(params)

        assert linkResource.save() != null

        // test invalid parameters in update
        params.id = linkResource.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/linkResource/edit"
        assert model.linkResourceInstance != null

        linkResource.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/linkResource/show/$linkResource.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        linkResource.clearErrors()

        populateValidParams(params)
        params.id = linkResource.id
        params.version = -1
        controller.update()

        assert view == "/linkResource/edit"
        assert model.linkResourceInstance != null
        assert model.linkResourceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/linkResource/list'

        response.reset()

        populateValidParams(params)
        def linkResource = new LinkResource(params)

        assert linkResource.save() != null
        assert LinkResource.count() == 1

        params.id = linkResource.id

        controller.delete()

        assert LinkResource.count() == 0
        assert LinkResource.get(linkResource.id) == null
        assert response.redirectedUrl == '/linkResource/list'
    }
}
