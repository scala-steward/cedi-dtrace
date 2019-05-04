/*
 * Copyright 2019 Combined Conditional Access Development, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ccadllc.cedi.dtrace
package logging

import cats.effect.Sync

import scala.language.higherKinds

import io.chrisdavenport.log4cats.log4s.Log4sLogger

/**
 * Provides the for the platform-specific initialization of the underlying logging
 * configuration for the JavaScript platform, using `log4s`.
 */
object LoggingConfig {
  def createLoggers[F[_]: Sync](names: Loggers.Names): Loggers[F] = new Loggers(
    Log4sLogger.createByName[F](names.text),
    Log4sLogger.createByName[F](names.json))
}