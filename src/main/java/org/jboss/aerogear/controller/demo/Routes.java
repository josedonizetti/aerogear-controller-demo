/***
 * JBoss, Home of Professional Open Source
 * Copyright ${year}, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.aerogear.controller.demo;

import org.jboss.aerogear.controller.RequestMethod;
import org.jboss.aerogear.controller.demo.model.Car;
import org.jboss.aerogear.controller.router.AbstractRoutingModule;

/**
* Routes are the core of aerogear-controller–demo.
* It's where we bind the the application bussines controller {@link Home} 
* to the URL that it will respond.<br>
* All the configuration is done with a type safe DSL.
*
* @see Home
*/

public class Routes extends AbstractRoutingModule {

	/**
	 * Entry point to configure routes mapping to pojo controllers.
	 * <pre>
	 * 	route()
	 *		.from("/")
	 *		.on(ResquestMethod.GET)
	 *		.from(Home.class).index();
	 * </pre>
	 */
    @Override
    public void configuration() {
        route()
                .from("/")
                .on(RequestMethod.GET)
                .to(Home.class).index();
        route()
                .from("/delorean")
                .on(RequestMethod.GET)
                .to(Home.class).anotherPage();
        route()
                .from("/cars")
                .on(RequestMethod.POST)
                .to(Home.class).save(param(Car.class));
    }
}
