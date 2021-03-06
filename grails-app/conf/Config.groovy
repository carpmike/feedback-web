import java.io.ObjectOutputStream.DebugTraceInfoStack;

import javax.swing.plaf.metal.MetalBorders.WarningDialogBorder;

// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }

	mail {
	  host = "smtp.gmail.com"
	  port = 465
	  username = "carpmike@gmail.com"
	  password = "oshvlkmdkdxjskmc"
	  props = ["mail.smtp.auth":"true",
			   "mail.smtp.socketFactory.port":"465",
			   "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
			   "mail.smtp.socketFactory.fallback":"false"]
	  from="server@yourhost.com"
	}
}
 
grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        grails.serverURL = "http://feedbock.elasticbeanstalk.com"
    }
}

// log4j configuration
log4j = {
    appenders {
		environments {
			development {
				file name:'file', file:'logs/feedback-web.log', layout:pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
			}
		}
        console name:'stdout', layout:pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
        error stdout: "StackTrace"
    }
	
	error  	'org.codehaus',
			'org.springframework',
			'org.springsource',
			'org.hibernate',
			'net.sf.ehcache',
			'org.grails.plugin',
			'org.apache'
	
	warn	'org.mortbay.log',
			'grails.util',
			'grails.plugin',
			'grails.spring'
	 
	debug	'feedback'
	
	environments {
		development {
			root {
				error 'file'
				info 'file'
				warn 'file'
				debug 'file'
				additivity = true
			}
		}
		production {
			root {
				error 'stdout'
				info 'stdout'
				warn 'stdout'
				debug 'stdout'
				additivity = true
			}
		}
	}
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"

grails.plugin.springsecurity.userLookup.userDomainClassName = 'feedback.web.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'feedback.web.UserRole'
grails.plugin.springsecurity.authority.className = 'feedback.web.Role'

environments {
	development {
		// show 500 and error page if can't get to resource
		grails.plugin.springsecurity.rejectIfNoRule = false
		grails.plugin.springsecurity.fii.rejectPublicInvocations = true		
	}
	production {
		// show a 403 error if can't get to resource
		grails.plugin.springsecurity.rejectIfNoRule = true
		grails.plugin.springsecurity.fii.rejectPublicInvocations = false
	}
}

grails.plugin.springsecurity.interceptUrlMap = [
	'/api/guest/**': 				['permitAll'],
	'/**/js/**':                    ['permitAll'],
	'/**/css/**':                   ['permitAll'],
	'/**/images/**':                ['permitAll'],
	'/**/favicon.ico':              ['permitAll'],
	'/login/**': 					['permitAll'],
	'/logout/**': 					['permitAll'],
	'/':                            ['IS_AUTHENTICATED_REMEMBERED', 'permitAll'],
	'/index':                       ['IS_AUTHENTICATED_REMEMBERED', 'ROLE_ADMIN'],
	'/index.gsp':                   ['IS_AUTHENTICATED_REMEMBERED', 'ROLE_ADMIN'],
	'/api/categories/**': 			['IS_AUTHENTICATED_REMEMBERED', 'permitAll'],
	'/api/feedbacks/**': 			['IS_AUTHENTICATED_REMEMBERED', 'permitAll'],
	'/api/feedbacktypes/**':		['IS_AUTHENTICATED_REMEMBERED', 'permitAll'],
	'/api/persons/**':				['IS_AUTHENTICATED_REMEMBERED', 'permitAll'],
	'/api/reminders/**':			['IS_AUTHENTICATED_REMEMBERED', 'permitAll']
]
	
grails.plugin.springsecurity.filterChain.chainMap = [
	'/api/guest/**': 'anonymousAuthenticationFilter,restTokenValidationFilter,restExceptionTranslationFilter,filterInvocationInterceptor',
	'/api/**': 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter',
	'/**': 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
]

// grails.plugin.springsecurity.useBasicAuth = true
// grails.plugin.springsecurity.basic.realmName = "Feedback"

// for the cors plugin
cors.headers = ['Access-Control-Allow-Headers':'origin, authorization, accept, content-type, x-requested-with, x-auth-token']

// authn handled by rest endpoint plugin
grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
grails.plugin.springsecurity.rest.login.endpointUrl = "/api/login"
grails.plugin.springsecurity.rest.logout.endpointUrl = "/api/logout"
grails.plugin.springsecurity.rest.login.failureStatusCode = 401
grails.plugin.springsecurity.rest.login.useRequestParamsCredentials = false
grails.plugin.springsecurity.rest.login.useJsonCredentials = true
grails.plugin.springsecurity.rest.login.usernamePropertyName = "username"
grails.plugin.springsecurity.rest.login.passwordPropertyName = "password"
grails.plugin.springsecurity.rest.token.storage.useGorm = true
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = "feedback.web.AuthenticationToken"

grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true

// for database migrations
environments {
	development {
		grails.plugin.databasemigration.updateOnStart = false
		grails.plugin.databasemigration.updateOnStartFileNames = ['db_updates_08-29-2014.groovy']
    }
    production {
		grails.plugin.databasemigration.updateOnStart = false
		grails.plugin.databasemigration.updateOnStartFileNames = ['db_updates_08-29-2014.groovy']
    }
}