<!Doctype>
<html>

<head>
	<title>Test</title>
</head>
<body>


<?php include 'libs/facebook.php'; ?>
<?php
$facebook = new Facebook()(array(
	'appid' => '136853983126404';
	'secret'=> 'e5b3682d101df80854b8f100113746b6';
	'cookie'=> true;

));

$session = $facebook-> getSession();
$i_am = null;

if($session)
{
	//fb query
	try
	{
	  $i_am = $facebook->api('/me/friends');
	  $facebook ->api('me/friends', 'post' , array(
		'message' => 'Hello world'));	
	}
	catch (FacebookApiException $e)
	{
	  echo $e->getMessage();
	}
}

if($i_am)
{
  $logoutUrl = $facebook->getLogoutUrl();;
  echo "<a href="$logoutUrl">Logout</a>";	
}
else
{

  $loginUrl= $facebook->getLoginUrl(array(
	'req_perm' => 'publish_stream ,read_friendlist'));

 $request = (isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] == 'on') ? 'https' : 'http';
 $likes = variable_get('PROFILE_ID,likes,PAGE_ID,user_likes,friends_like') ;
 echo $likes;
 echo "<a href= "$loginUrl">Login</a>";

}


?>
</body>
</html>



