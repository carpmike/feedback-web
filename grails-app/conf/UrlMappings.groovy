class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }
		
		// for restful interface
		"/reminders"(resources:'reminder', includes:['save'])
		"/feedbacks"(resources:'feedback')

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
