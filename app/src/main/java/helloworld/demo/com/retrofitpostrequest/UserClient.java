package helloworld.demo.com.retrofitpostrequest;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserClient {


    @FormUrlEncoded
    @POST("apiregister.php")
    Call<User>createAccount(

            @Field("name") String name,
            @Field("email") String email,
            @Field("pass") String password

    );


}
