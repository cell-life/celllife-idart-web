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
            bootstrap:
                src: [ 'src/scripts/js/bootstrap/*.js' ]
                dest: 'js/bootstrap.min.js'
            main:
                src: [ 'js/main.js' ]
                dest: 'js/main.min.js'
            settings:
                src: [ 'src/scripts/js/settings.js' ]
                dest: 'js/settings.min.js'

        coffee:
            compile:
                files:
                    'js/main.js': 'src/scripts/coffee/main.coffee'

        watch:
            compass:
                files: 'src/styles/sass/**/*.sass',
                tasks: 'compass'
                options:
                    nospawn: true
            less:
                files: 'src/styles/less/**/*.less',
                tasks: 'less'
                options:
                    nospawn: true
            coffee:
                files: 'src/scripts/coffee/**/*.coffee',
                tasks: 'coffee'
                options:
                    nospawn: true
            scripts:
                files: 'src/scripts/js/**/*.js',
                tasks: 'uglify'
                options:
                    nospawn: true

        reloadr:
            files: ['css/**/*.css', 'js/**/*.js']


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
    grunt.registerTask 'ninja', ['reloadr', 'watch']
