package br.com.cco2anpi.services.controllers.tests;

//import static org.junit.Assert.assertEquals;

//import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
//import org.springframework.test.context.web.WebAppConfiguration;

//import br.com.cco2anpi.services.controllers.UserController;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath:/WEB-INF/services-servlet.xml"})
public class ServiceTest {

//	  private MockHttpServletRequest request;
//	  private MockHttpServletResponse response;
//	  private UserController controller;


	  @Before
	  public void setUp() {

//	    controller = EasyMock.createNiceMock(UserController.class);

//	    adapter = new AnnotationMethodHandlerAdapter();
//	    request = new MockHttpServletRequest();
//	    response = new MockHttpServletResponse();
	  }


	  @Test
	  public void testname() throws Exception {
		 Assert.assertTrue(true);
		  
//	    request.setRequestURI("/users");
//
//	    controller.foo(response);
//	    EasyMock.expectLastCall().once();
//	    EasyMock.replay(controller);
//
//	    adapter.handle(request, response, controller);
//
//	    EasyMock.verify(controller);
	  }
}