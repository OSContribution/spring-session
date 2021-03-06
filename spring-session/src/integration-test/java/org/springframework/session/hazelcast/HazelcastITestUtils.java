/*
 * Copyright 2002-2016 the original author or authors.
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

package org.springframework.session.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import org.springframework.util.SocketUtils;

/**
 * Utility class for Hazelcast integration tests.
 *
 * @author Vedran Pavic
 */
public class HazelcastITestUtils {

	/**
	 * Creates {@link HazelcastInstance} for use in integration tests.
	 * @param port the port for Hazelcast to bind to
	 * @return the Hazelcast instance
	 */
	public static HazelcastInstance embeddedHazelcastServer(int port) {
		Config config = new Config();
		config.getNetworkConfig()
				.setPort(port);
		return Hazelcast.newHazelcastInstance(config);
	}

	/**
	 * Creates {@link HazelcastInstance} for use in integration tests.
	 * @return the Hazelcast instance
	 */
	public static HazelcastInstance embeddedHazelcastServer() {
		return embeddedHazelcastServer(SocketUtils.findAvailableTcpPort());
	}

}
