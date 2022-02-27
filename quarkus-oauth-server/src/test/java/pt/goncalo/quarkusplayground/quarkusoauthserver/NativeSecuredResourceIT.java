package pt.goncalo.quarkusplayground.quarkusoauthserver;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeSecuredResourceIT extends SecuredResourceTest {

    // Execute the same tests but in native mode.
}