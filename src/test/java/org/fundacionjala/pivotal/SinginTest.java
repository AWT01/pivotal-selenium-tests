package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.AbstractPage;
import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
import org.testng.annotations.Test;

/**
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */

public class SinginTest extends AbstractPage {

  @Test
  public void SiginByEmail() {
    SignInPage.loginAs("elianor@gmail.com","");

  }
}
