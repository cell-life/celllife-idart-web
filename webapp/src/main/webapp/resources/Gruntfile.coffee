module.exports = (grunt) ->

    # Project configuration.
    grunt.initConfig

        cssmin:
            application:
                src: 'css/application.css'
                dest: 'css/application.min.css'

        compass:
            dist:
                options:
                    cssDir: 'css'
                    sassDir: 'src/styles/sass'
                    imagesDir: 'src/images'
                    javascriptsDir: 'src/scripts/js'
                    fontsDir: 'src/fonts'
                    outputStyle: 'nested'
                    relativeAssets: true
                    noLineComments: true

        uglify:
            options:
                preserveComments: 'none'
            main:
                src: [ 'js/main.js' ]
                dest: 'js/main.min.js'

        coffee:
            compile:
                files:
                    'js/main.js': 'src/scripts/coffee/main.coffee'
                    'js/app.js': 'src/scripts/coffee/app.coffee'

        handlebars:
            compile:
                files:
                    "app/scripts/templates.js" : ["app/aura_components/**/*.hbs"]
                options:
                    wrapped: true
                    namespace: "Handlebars.templates"
                    processName: (filename) ->
                        return filename.replace(/^app\/aura_components\//, '').replace(/\.hbs$/, '')

        watch:
            compass:
                files: 'src/styles/sass/**/*',
                tasks: 'compass'
            coffee:
                files: 'src/scripts/coffee/**/*',
                tasks: 'coffee'
            scripts:
                files: 'src/scripts/js/**/*',
                tasks: 'uglify'


    # Load modules.
    grunt.loadNpmTasks 'grunt-devtools'
    grunt.loadNpmTasks 'grunt-reloadr'
    grunt.loadNpmTasks 'grunt-css'
    grunt.loadNpmTasks 'grunt-contrib-watch'
    grunt.loadNpmTasks 'grunt-contrib-uglify'
    grunt.loadNpmTasks 'grunt-contrib-compass'
    grunt.loadNpmTasks 'grunt-contrib-less'
    grunt.loadNpmTasks 'grunt-contrib-coffee'
    grunt.loadNpmTasks 'grunt-contrib-requirejs'

    # Grunt tasks.
    grunt.registerTask 'default', ['compass', 'coffee', 'uglify', 'cssmin']