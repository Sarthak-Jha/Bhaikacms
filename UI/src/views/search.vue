<template>

<div v-if="getSearchResult.multiVideoProgram.content.length==0 && getSearchResult.singleVideoProgram.content.length==0 && getSearchResult.seasonalVideoProgram.content.length==0" class="card-wrapper">
No Result Found
</div>
 <div v-else>
     <div v-if="getSearchResult.singleVideoProgram.content.length!==0">
         <h3>Single Video Program Search results</h3>
 <div  v-for="(search, index) in getSearchResult.singleVideoProgram.content" :key="index"  class="card">
    <div class="row ">
        <div class="col-md-4">
            <img width="300" height="180"  :src="search.imgUrls.thumbnail" class="w-100">
        </div>
        <div class="col-md-8 px-3">
            <div class="card-block col-md-8 px-2">
                <div class="help"> </div>
                <p class="card-text"><b>Name : </b>{{ search.name }}</p>
                <p class="card-text"><b>Description : </b>{{ search.description }}</p>
                <p class="card-text"><b>Categories : </b>{{ search.path }}</p>
                <p class="card-text"><b>Languages : </b>{{ search.languages }}</p>
                <p class="card-text"><b>Parental Rating : </b>{{ search.parentalRating }} +</p>
            </div>
           
        </div> 
    </div>
</div>
     </div>
     <div v-if="getSearchResult.multiVideoProgram.content.length!==0">
         <h3>Multi Video Program Search results</h3>
 <div  v-for="(search, index) in getSearchResult.multiVideoProgram.content" :key="index"  class="card">
    <div class="row ">
        <div class="col-md-4">
            <img width="300" height="180"  :src="search.imgUrls.thumbnail" class="w-100">
        </div>
        <div class="col-md-8 px-3">
            <div class="card-block col-md-8 px-2">
                <div class="help"> </div>
                <p class="card-text"><b>Name : </b>{{ search.name }}</p>
                <p class="card-text"><b>Description : </b>{{ search.description }}</p>
                <p class="card-text"><b>Categories : </b>{{ search.path }}</p>
                <p class="card-text"><b>Languages : </b>{{ search.languages }}</p>
                <p class="card-text"><b>Parental Rating : </b>{{ search.parentalRating }} +</p>
            </div>
           
        </div> 
    </div>
</div>
     </div>
     <div v-if="getSearchResult.seasonalVideoProgram.content.length!==0">
         <h3>Seasonal Video Program Search results</h3>
 <div  v-for="(search, index) in getSearchResult.seasonalVideoProgram.content" :key="index"  class="card">
    <div class="row ">
        <div class="col-md-4">
            <img width="300" height="180"  :src="search.imgUrls.thumbnail" class="w-100">
        </div>
        <div class="col-md-8 px-3">
            <div class="card-block col-md-8 px-2">
                <div class="help"> </div>
                <p class="card-text"><b>Name : </b>{{ search.name }}</p>
                <p class="card-text"><b>Description : </b>{{ search.description }}</p>
                <p class="card-text"><b>Categories : </b>{{ search.path }}</p>
                <p class="card-text"><b>Languages : </b>{{ search.languages }}</p>
                <p class="card-text"><b>Parental Rating : </b>{{ search.parentalRating }} +</p>
            </div>
           
        </div> 
    </div>
</div>
     </div>
       
</div>
</template>
<script src="./js/search.js"></script>
<style>
.card-wrapper {
    padding:10px;
}
.card {
    border:1px solid black;
    margin:10px;
    padding:10px;
}
  .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 95%;
        width: 30px;
        height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 30px !important;
        text-align: center;
        padding: 0;
    }
    .pagination li a:hover {
        color: #666;
    }   
    .pagination li.active a {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
    .pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 6px;
        font-size: 95%;
    }  
    .msg {
        height:30px;
        padding:10px;
        margin:10px;
        color:red;
    }
</style>