package blackJack;


import Controller.ControllerFileTest;
import Controller.ControllerJogadorTest;
import Controller.ControllerPartidaTest;
import model.BaralhoTest;
import model.CartaTest;
import model.CroupierTest;
import model.JogadorTest;
import model.MaoDeCartaTest;
import model.PartidaTest;
import org.junit.runner.*;
import org.junit.runners.*;
import util.StackTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BaralhoTest.class,
	CartaTest.class,
	CroupierTest.class,
	JogadorTest.class,
        PartidaTest.class,
        MaoDeCartaTest.class,
        StackTest.class,
        ControllerFileTest.class,
        ControllerJogadorTest.class,
        ControllerPartidaTest.class
        
                
        
})
public class AllTests { }