<template>
<div class="box">
    <form class="program-form" style="padding:15px;" @submit.prevent="handleSubmit()">
        <h2 class="form-heading">PROGRAM FORM</h2>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Program type</label>
                <input v-model="program.type" type="text" class="form-control " required readOnly>
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Program name</label>
                <input v-model="program.name"  type="text" class="form-control" required>
            </div>
        </div>
        <div class="form-group col-md-12">
            <label for="inputAddress">Description</label>
            <input v-model="program.description"  type="text" class="form-control" required>
        </div>
        <div class="form-group col-md-12">
            <label for="inputAddress2">Keywords</label>
            <vue-tags-input v-model="tag" :tags="tags" @tags-changed="newTags => tags = newTags"/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputCity">Parental rating</label>
                <select class="form-control" v-model="program.parentalRating">
                    <option value="7">7+</option>
                    <option value="13">13+</option>
                    <option value="18">18+</option>
                    <option value="all">all</option>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="inputState">Language</label>
                <select class="form-control" v-model="program.languages">
                    <option v-for="language in languages" :key="language.name" :value="language.name">{{ language.name }}</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="inputCity">Start date</label>
                <input  v-model="program.startDate" type="datetime-local" class="form-control" >
            </div>
            <div class="form-group col-md-4">
                <label for="inputZip">Expiry date</label>
                <input v-model="program.expiryDate" type="datetime-local" class="form-control" >
            </div>
             <div class="form-group col-md-4">
                <label for="inputState">Category</label>
                <select id="inputState" class="form-control" v-model="program.category.id">
                    <option v-for="element in getStackOfCategories" :key="element.id" :value="element.id">{{ element.name }}</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Thumbnail</label>
                <input @change="processFile($event,'Thumbnail')" type="file" class="form-control">
                <img height="50" width="50" v-if="program.imgUrls.thumbnail" :src="program.imgUrls.thumbnail" alt="">
            </div>
            <div class="form-group col-md-4">
                <label>Avatar</label>
                <input @change="processFile($event,'Avatar')" type="file" class="form-control">
                <img height="50" width="50" v-if="program.imgUrls.avatar" :src="program.imgUrls.avatar" alt="">
            </div>
        </div>
        <div @click="addInput" class="btn btn-primary"> Add Crew </div>
       <br>
       <br>
       <div class="col-sm-6" v-for="(input, index) in inputArray" :key="index">
       <span>
           <select class="form-group col-sm-2" v-model="input.role">
               <option  v-for="crew in crewRoles" :key="crew.id">{{crew.role}}</option>
           </select>
           <br>
           <input v-model="input.roleName" type="text" class="form-control">
           <br>
           <div :v-model="input.roleName" @click="removeInput(index)" class="btn btn-primary"> Remove </div>
           <br>
       </span>
       </div>
       <br>

        <div class="button">
            <span class="button1"><button type="submit" class="btn btn-primary">Save program</button></span>
            <span class="button1"><button @click="handleCancel()"  class="btn btn-primary">Close</button></span>
        </div>
    </form>
</div>   
</template>

<script src="./js/program.js"></script>

<style scoped>
.box {
    padding:20px;
    margin:20px;
    height:auto;
    border-radius: 10px;
	box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
}
.form-heading {
    text-align:center;
    color: #2980B9;
}
.button {
    margin-top:400px;
}
.button1 {
    margin:10px;
}
</style>
