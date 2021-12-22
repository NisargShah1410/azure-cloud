/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.chtrembl.petstore.order.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import com.chtrembl.petstore.order.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-21T10:17:19.885-05:00")

@Api(value = "store", description = "the store API")
public interface StoreApi {

	default Optional<NativeWebRequest> getRequest() {
		return Optional.empty();
	}

	@ApiOperation(value = "Delete purchase order by ID", nickname = "deleteOrder", notes = "For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors", tags = {
			"store", })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Order not found") })
	@RequestMapping(value = "/store/order/{orderId}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteOrder(
			@Min(1L) @ApiParam(value = "ID of the order that needs to be deleted", required = true) @PathVariable("orderId") Long orderId);

	@ApiOperation(value = "Returns product inventories by status", nickname = "getInventory", notes = "Returns a map of status codes to quantities", response = Integer.class, responseContainer = "Map", authorizations = {
			@Authorization(value = "api_key") }, tags = { "store", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation", response = Map.class, responseContainer = "Map") })
	@RequestMapping(value = "/store/inventory", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Map<String, Integer>> getInventory();

	@ApiOperation(value = "Find purchase order by ID", nickname = "getOrderById", notes = "For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions", response = Order.class, tags = {
			"store", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Order.class),
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Order not found") })
	@RequestMapping(value = "/store/order/{orderId}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	ResponseEntity<Order> getOrderById(
			@Min(1L) @Max(10L) @ApiParam(value = "ID of product that needs to be fetched", required = true) @PathVariable("orderId") Long orderId);

	@ApiOperation(value = "Place an order for a product", nickname = "placeOrder", notes = "", response = Order.class, tags = {
			"store", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Order.class),
			@ApiResponse(code = 400, message = "Invalid Order") })
	@RequestMapping(value = "/store/order", produces = { "application/json", "application/xml" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<List<Order>> placeOrder() {
		getRequest().ifPresent(request -> {
			try {
				StoreApiController.log.info(String.format(
						"PetStoreOrderService incoming POST request to petstoreorderservice/v2/order/placeOder"));
				String orderJSON = new ObjectMapper().writeValueAsString("test");
				ApiUtil.setResponse(request, "application/json", orderJSON);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				String exampleString = e.getMessage();
				ApiUtil.setResponse(request, "application/json", exampleString);
			}
		});

		return new ResponseEntity<>(HttpStatus.OK);

	}

}