<?php

return array(
    'view_manager' => array(
        'template_path_stack' => array(
            __DIR__ . '/../view',
        ),
    ),
    'router' => array(
        'routes' => array(
            'zf2test' => array(
                'type' => 'Zend\Mvc\Router\Http\Literal',
                'options' => array(
                    'route' => '/zf2test',
                    'defaults' => array(
                        'controller' => 'zf2test\Controller\Index',
                        'action' => 'index'
                    )
                )
            ),
            
        )
    ),
    'controllers' => array(
        'factories' =>array(
            'zf2test\Controller\Index' => function($serviceLocator)
            {
                $ctr = new zf2test\Controller\IndexController();
                $ctr->setGreetingService($serviceLocator->getServiceLocator()->get('greetingService'));
                return $ctr;
            }
        ),
        //'invokables' => array(
        //    'zf2test\Controller\Index' => 'zf2test\Controller\IndexController'
        //)
    ),
    'service_manager' => array(
        'invokables' => array(
            'greetingService' => 'zf2test\Service\GreetingService'      
        )
    )
);

?>
