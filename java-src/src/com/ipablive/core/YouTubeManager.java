/**
 * 
 */
package com.ipablive.core;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.data.extensions.Comments;
import com.google.gdata.data.media.mediarss.MediaThumbnail;
import com.google.gdata.data.youtube.CommentEntry;
import com.google.gdata.data.youtube.CommentFeed;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.data.youtube.YouTubeMediaContent;
import com.google.gdata.data.youtube.YouTubeMediaGroup;
import com.ipablive.vo.YouTubeMedia;
import com.ipablive.vo.YouTubeVideoVO;

/**
 * @author 
 *
 */
public class YouTubeManager 
{
	//private static final String YOUTUBE_URL = "http://www.youtube.com/rss/user/ipaidabribe/videos.rss";
	private static final String YOUTUBE_URL = "http://gdata.youtube.com/feeds/api/videos";
    private static final String YOUTUBE_EMBEDDED_URL = "http://www.youtube.com/v/";
    private static final String QUERY = "ipaidabribe";

	/* Here is the instance of the Singleton */
	  private static YouTubeManager _videosInstance;
	  
	  private YouTubeService service;

	  //Prevent direct access to the constructor
	  private YouTubeManager() 
	  {
	    super();
	  }
	  
	  public static YouTubeManager getInstance() 
	  {

	    if (_videosInstance == null) 
	    {

	      synchronized(YouTubeManager.class) 
	      {

	        if (_videosInstance == null) 
	        {
	        	_videosInstance = new YouTubeManager();
	        }

	      }

	    }
	    
	    return _videosInstance;
	  }
	
	public List<YouTubeVideoVO> retrieveVideos(int maxResults) throws Exception 
	{
        service = new YouTubeService(QUERY);
        service.setConnectTimeout(2000); // millis
        YouTubeQuery query = new YouTubeQuery(new URL(YOUTUBE_URL));
   
        query.setOrderBy(YouTubeQuery.OrderBy.VIEW_COUNT);
        query.setFullTextQuery(QUERY);
        query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
        if(maxResults>0)
        {
        	query.setMaxResults(maxResults);
        }
        
 
        VideoFeed videoFeed = service.query(query, VideoFeed.class); 
        List<VideoEntry> videos = videoFeed.getEntries();
   
        return convertVideos(videos);
   
    }
	
	private List<YouTubeVideoVO> convertVideos(List<VideoEntry> videos) 
	{
			   
        List<YouTubeVideoVO> youtubeVideosList = new LinkedList<YouTubeVideoVO>();
   
        for (VideoEntry videoEntry : videos) 
        {
        	
        	YouTubeVideoVO ytv = new YouTubeVideoVO();
        	TextConstruct tc = videoEntry.getTitle();
        	ytv.setVideoTitle(tc.getPlainText());
    
            YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();
            String webPlayerUrl = mediaGroup.getPlayer().getUrl();
            ytv.setWebPlayerUrl(webPlayerUrl);
    
            String query = "?v=";
            int index = webPlayerUrl.indexOf(query);
 
            String embeddedWebPlayerUrl = webPlayerUrl.substring(index+query.length());
            embeddedWebPlayerUrl = YOUTUBE_EMBEDDED_URL + embeddedWebPlayerUrl;
            ytv.setEmbeddedWebPlayerUrl(embeddedWebPlayerUrl);
    
            List<String> thumbnails = new LinkedList<String>();
            for (MediaThumbnail mediaThumbnail : mediaGroup.getThumbnails()) 
            {
                thumbnails.add(mediaThumbnail.getUrl());
            }  
            ytv.setThumbnails(thumbnails);
    
            List<YouTubeMedia> medias = new LinkedList<YouTubeMedia>();
            for (YouTubeMediaContent mediaContent : mediaGroup.getYouTubeContents()) 
            {
                medias.add(new YouTubeMedia(mediaContent.getUrl(), mediaContent.getType()));
            }
            ytv.setMedias(medias);
            
            String commentUrl = videoEntry.getComments().getFeedLink().getHref();
            
            try{
	            CommentFeed commentFeed = service.getFeed(new URL(commentUrl), CommentFeed.class);
	            ArrayList<String> videoComments = new ArrayList<String>();
	            
	            for(CommentEntry comment : commentFeed.getEntries()) 
	            {
	            	String videoComm = comment.getPlainTextContent();
	            	videoComments.add(videoComm);
	            }
	            ytv.setVideoComments(videoComments);
            }catch (Exception e) 
            {
			}
    
            youtubeVideosList.add(ytv);
    
        }
   
        return youtubeVideosList;
   
    }

	
	public static void main(String[] args) throws Exception 
	{
			   
        int maxResults = 10;
   
        YouTubeManager ym = YouTubeManager.getInstance();
   
        List<YouTubeVideoVO> videos = ym.retrieveVideos(2);
   
        for (YouTubeVideoVO youtubeVideo : videos) {
            System.out.println(youtubeVideo.getWebPlayerUrl());
            System.out.println("Thumbnails");
            for (String thumbnail : youtubeVideo.getThumbnails()) {
                System.out.println("\t" + thumbnail);
            }
            System.out.println(youtubeVideo.getEmbeddedWebPlayerUrl());
            System.out.println("************************************");
        }
   
    }

		


		


}
