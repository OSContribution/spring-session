/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.pages

import geb.*

/**
 * The home page
 *
 * @author Rob Winch
 */
class HomePage extends Page {
	static url = ''
	static at = { assert driver.title == 'Spring Session Sample - Secured Content'; true}
	static content = {
		username { $('#un').text() }
		logout(to:LoginPage) { $('input[type=submit]').click() }
		sessions { moduleList AttributeRow, $("table tr").tail() }
		terminate(required:false) { sessionId -> $("#terminate-$sessionId") }
		sessionId { $("#session-id").text() }
	}
}

class AttributeRow extends Module {
	static content = {
		cell { $("td", it) }
		location { cell(0).text() }
		created { cell(1).text() }
		lastUpdated { cell(2).text() }
		information { cell(3).text() }
		terminate { cell(4).text() }
	}
}
