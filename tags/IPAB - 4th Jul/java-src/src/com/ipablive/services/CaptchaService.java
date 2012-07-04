package com.ipablive.services;

/**
 * Servlet implementation class CaptchaServlet
 */

    import java.awt.Color;
	import java.awt.Font;
	import java.awt.GradientPaint;
	import java.awt.Graphics2D;
	import java.awt.image.BufferedImage;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.util.Random;
	import javax.imageio.ImageIO;
	import javax.servlet.ServletConfig;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;



    public class CaptchaService extends HttpServlet 
    {
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CAPCHA_TYPE_NUMBER = "num";
	private static final String CAPCHA_TYPE_ALPHANUM = "alphanum";
	private static final String CAPCHA_TYPE_ALPHA = "alpha";
	    
	  public static String CAPTCHA_KEY = "";

	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    
	  }

	 
	 protected void doGet(HttpServletRequest req, HttpServletResponse response) 
	   throws IOException, ServletException {
	    //Expire response
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0);
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Max-Age", 0);
	    
	    String token = "";
	    String ch = "";
	    int height=0;
	    int width=0;
	    
	    String type = req.getParameter("type");
	    if(type==null)
	    {
	    	//alpha numeric
	    	Random r = new Random();
		    token = Long.toString(Math.abs(r.nextLong()), 36);
		    ch = token.substring(0,6);
		    height=32;
		    width=122;
	    }else if(type.equalsIgnoreCase(CAPCHA_TYPE_NUMBER))
	    {
	    	//creates a random number between 1000 to 9999
	    	int x = (int)(Math.random() * 9999)+1000;
	    	token = ""+x;
	    	ch = token.substring(0,4);
	    	height=32;
		    width=78;
	    }
	    
	    System.out.println("Generated code  :: "+ ch);
	    
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
	    Graphics2D graphics2D = image.createGraphics();
	    
	    Color c = new Color(0.6662f, 0.4569f, 0.3232f);
	    GradientPaint gp = new GradientPaint(30, 30, c, 15, 25, Color.white, true);
	    graphics2D.setPaint(gp);
	    Font font=new Font("Verdana", Font.CENTER_BASELINE , 26);
	    graphics2D.setFont(font);
	    graphics2D.drawString(ch,3,25);
	    graphics2D.dispose();
	    
	    HttpSession session = req.getSession(true);
	    session.setAttribute("Code",ch);
	    System.out.println(session.getMaxInactiveInterval() +" <>  "+ session.getCreationTime());
	    OutputStream outputStream = response.getOutputStream();
	    ImageIO.write(image, "png", outputStream);
	    outputStream.close();

	 }

}
