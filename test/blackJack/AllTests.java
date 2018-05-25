package blackJack;


import modelTest.BaralhoTest;
import modelTest.CartaTest;
import modelTest.CroupierTest;
import modelTest.JogadorTest;
import modelTest.MaoDeCartaTest;
import org.junit.runner.*;
import org.junit.runners.*;
import util.StackTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BaralhoTest.class,
	CartaTest.class,
	CroupierTest.class,
	JogadorTest.class,
        MaoDeCartaTest.class,
        StackTest.class
        
})
public class AllTests { }