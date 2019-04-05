package com.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PostDAOImpl;

@Path("postbook")
public class MyResource {

	PostDAOImpl impl = new PostDAOImpl();
	
	@Path("posts/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts() {
		return impl.view();
	}
	
	@Path("posts/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Post addPost(Post post) {
		return impl.insert(post);
	}
	
	@Path("posts/edit")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Post update(Post post) {
		return impl.update(post);
	}
	
	@Path("posts/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Status deletePost(@PathParam("id") int id) {
		return impl.delete(new Post(id,"",""));
	}
	
       

	
}