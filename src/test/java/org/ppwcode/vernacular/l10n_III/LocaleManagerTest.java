/*<license>
Copyright 2009 - $Date: 2008-10-15 18:22:22 +0200 (Wed, 15 Oct 2008) $ by PeopleWare n.v..

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</license>*/

package org.ppwcode.vernacular.l10n_III;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Locale;

import org.junit.After;
import org.junit.Test;

public class LocaleManagerTest {

  private final static List<Locale> EMPTY_LOCALE_LIST = new ArrayList<Locale>();

  private final static String[] SUPPORTED_LOCALES_1 = { "fr-BE", "fr-FR", "fr", "nl-BE", "nl-NL", "nl", "en-GB", "en-US", "en" };
  private final static String[] SUPPORTED_LOCALES_2 = { "fr-BE", "fr", "nl-BE", "nl", "en-GB", "en", "de-DE", "de" };
  private final static String[] SUPPORTED_LOCALES_3 = { "it-IT", "it", "fr-BE", "fr", "nl-BE", "nl", "en-GB", "en" };
  private final static String[] SUPPORTED_LOCALES_4 = { "nl-BE", "nl", "en-GB", "en", "fr-BE", "fr" };
  private final static String[] SUPPORTED_LOCALES_5 = { "en", "de", "fr", "nl" };

  private final static String APP_1 = "org.ppwcode.vernacular.l10n_III";
  private final static String APP_2 = "org.ppwcode.vernacular.semantics_VI";
  private final static String APP_3 = "org.ppwcode.vernacular.semantics_V";
  private final static String APP_4 = "org.ppwcode.vernacular.resourcebundle_II";
  private final static String APP_5 = "org.ppwcode.util.dwr_I";

  @After
  public void tearDown() {
    LocaleManager.registerSupportedLocales(APP_1, EMPTY_LOCALE_LIST);
  }

  @Test
  public void testLocaleManager() {
    // empty in the beginning
    assertTrue(LocaleManager.getSupportedLocales().isEmpty());

    // register 1 application
    List<Locale> supportedLocales_1 = LocaleHelpers.constructListOfLocales(SUPPORTED_LOCALES_1);
    LocaleManager.registerSupportedLocales(APP_1, supportedLocales_1);
    assertEquals(supportedLocales_1, LocaleManager.getSupportedLocales(APP_1));
    assertEquals(supportedLocales_1, LocaleManager.getSupportedLocales());

    // register 2nd application
    List<Locale> supportedLocales_2 = LocaleHelpers.constructListOfLocales(SUPPORTED_LOCALES_2);
    LocaleManager.registerSupportedLocales(APP_2, supportedLocales_2);
    assertEquals(supportedLocales_2, LocaleManager.getSupportedLocales(APP_2));
    String[] expectedLocs_2 = { "fr-BE", "fr", "nl-BE", "nl", "en-GB", "en" };
    List<Locale> expectedLocales_2 = LocaleHelpers.constructListOfLocales(expectedLocs_2);
    assertEquals(expectedLocales_2, LocaleManager.getSupportedLocales());

    // register 3rd application
    List<Locale> supportedLocales_3 = LocaleHelpers.constructListOfLocales(SUPPORTED_LOCALES_3);
    LocaleManager.registerSupportedLocales(APP_3, supportedLocales_3);
    assertEquals(supportedLocales_3, LocaleManager.getSupportedLocales(APP_3));
    String[] expectedLocs_3 = { "fr-BE", "fr", "nl-BE", "nl", "en-GB", "en" };
    List<Locale> expectedLocales_3 = LocaleHelpers.constructListOfLocales(expectedLocs_3);
    assertEquals(expectedLocales_3, LocaleManager.getSupportedLocales());

    // register 4th application
    List<Locale> supportedLocales_4 = LocaleHelpers.constructListOfLocales(SUPPORTED_LOCALES_4);
    LocaleManager.registerSupportedLocales(APP_4, supportedLocales_4);
    assertEquals(supportedLocales_4, LocaleManager.getSupportedLocales(APP_4));
    String[] expectedLocs_4 = { "fr-BE", "fr", "nl-BE", "nl", "en-GB", "en" };
    List<Locale> expectedLocales_4 = LocaleHelpers.constructListOfLocales(expectedLocs_4);
    assertEquals(expectedLocales_4, LocaleManager.getSupportedLocales());

    // register 5th application
    List<Locale> supportedLocales_5 = LocaleHelpers.constructListOfLocales(SUPPORTED_LOCALES_5);
    LocaleManager.registerSupportedLocales(APP_5, supportedLocales_5);
    assertEquals(supportedLocales_5, LocaleManager.getSupportedLocales(APP_5));
    String[] expectedLocs_5 = { "fr", "nl", "en" };
    List<Locale> expectedLocales_5 = LocaleHelpers.constructListOfLocales(expectedLocs_5);
    assertEquals(expectedLocales_5, LocaleManager.getSupportedLocales());
  }

}
