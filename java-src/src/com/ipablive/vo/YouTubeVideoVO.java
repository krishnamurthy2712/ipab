/**
 * 
 */
package com.ipablive.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 *
 */
public class YouTubeVideoVO 
{
	private List<String> thumbnails;
    private List<YouTubeMedia> medias;
    private String webPlayerUrl;
    private String embeddedWebPlayerUrl;
    private String videoTitle;
    private ArrayList<String> videoComments;
    
  
     public List<String> getThumbnails() 
     {
          return thumbnails;
     }
     public void setThumbnails(List<String> thumbnails) 
     {
          this.thumbnails = thumbnails;
     }
 
     public List<YouTubeMedia> getMedias() 
     {
          return medias;
     }
     public void setMedias(List<YouTubeMedia> medias) 
     {
         this.medias = medias;
     }
  
     public String getWebPlayerUrl() 
     {
          return webPlayerUrl;
     }
     public void setWebPlayerUrl(String webPlayerUrl) 
     {
            this.webPlayerUrl = webPlayerUrl;
     }
 
     public String getEmbeddedWebPlayerUrl() 
     {
          return embeddedWebPlayerUrl;
     }
     public void setEmbeddedWebPlayerUrl(String embeddedWebPlayerUrl) 
     {
          this.embeddedWebPlayerUrl = embeddedWebPlayerUrl;
     }
  
     public String retrieveHttpLocation() 
     {
          if (medias==null || medias.isEmpty()) 
          {
               return null;
          }
          for (YouTubeMedia media : medias) 
          {
               String location = media.getLocation();
               if (location.startsWith("http")) 
               {
                    return location;
               }
          }
          return null;
      }
     
	public String getVideoTitle() 
	{
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) 
	{
		this.videoTitle = videoTitle;
	}
	
	public ArrayList<String> getVideoComments() 
	{
		return videoComments;
	}
	public void setVideoComments(ArrayList<String> videoComments) 
	{
		this.videoComments = videoComments;
	}


}
